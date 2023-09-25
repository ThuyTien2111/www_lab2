// Định nghĩa biến để lưu trữ danh sách sản phẩm và giỏ hàng
let products = [];
let cart = [];
let productsPerPage = 3; // Số sản phẩm trên mỗi trang
let currentPage = 1; // Trang hiện tại

// Lấy danh sách sản phẩm từ API và hiển thị trang đầu tiên
fetch('http://localhost:8080/lab2/api/products/show')
    .then(response => response.json())
    .then(data => {
        products = data;
        displayProducts(currentPage);
    })
    .catch(error => console.error('Lỗi khi tải danh sách sản phẩm:', error));

// Hiển thị danh sách sản phẩm trên trang cụ thể
function displayProducts(page) {
    let productList = document.getElementById('product-list');
    productList.innerHTML = '';

    let startIndex = (page - 1) * productsPerPage;
    let endIndex = startIndex + productsPerPage;

    for (let i = startIndex; i < endIndex && i < products.length; i++) {
        let product = products[i];
        let productDiv = document.createElement('div');
        productDiv.classList.add('product');
        productDiv.innerHTML = `
            <h3>${product.name}</h3>
            <p>Giá: $${product.price.toFixed(2)}</p>
            <img src="${product.path}" alt="${product.name}" height="150" width="200">
<button onclick="showOrderForm(${product.productID})" data-product-id="${product.productID}">Đặt hàng</button>
        `;
        productList.appendChild(productDiv);
    }

    // Hiển thị phân trang
    displayPagination();
}

// Hiển thị phân trang
function displayPagination() {
    let pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    let totalPages = Math.ceil(products.length / productsPerPage);

    for (let i = 1; i <= totalPages; i++) {
        let pageButton = document.createElement('button');
        pageButton.textContent = i;
        pageButton.addEventListener('click', () => {
            currentPage = i;
            displayProducts(currentPage);
        });
        pagination.appendChild(pageButton);
    }
}
function showOrderForm(productID) {
    // Lấy thông tin sản phẩm dựa vào productID
    let selectedProduct = products.find(product => product.productID === productID);

    // Hiển thị form đặt hàng và điền thông tin sản phẩm vào form
    let orderForm = document.getElementById('order-form');
    orderForm.style.display = 'block';

    // Điền thông tin sản phẩm vào form
    document.getElementById('product-name').textContent = selectedProduct.name;
    document.getElementById('product-price').textContent = `$${selectedProduct.price.toFixed(2)}`;
    document.getElementById('product-id-input').value = selectedProduct.productID;

    // Thêm sự kiện cho nút "Đặt hàng" trong form
    let orderButton = document.getElementById('order-button');
    orderButton.addEventListener('click', () => {
        let productID = parseInt(document.getElementById('product-id-input').value);
        let quantity = parseInt(document.getElementById('quantity-input').value);
        let orderID = document.getElementById('order-id-input').value;
        let customerID = document.getElementById('customer-id-input').value;
        let empID = document.getElementById('emp-id-input').value;
        let note = document.getElementById('note-input').value;

        // Gọi hàm addToCart để thêm đơn hàng vào giỏ hàng
        addToCart(productID, quantity, orderID, customerID, empID, note);

        // Ẩn form sau khi đã thêm vào giỏ hàng
        orderForm.style.display = 'none';
    });
}
function addToCart(productID, quantity, orderID, customerID, empID, note) {
    // Lấy thông tin sản phẩm dựa vào productID để cập nhật giỏ hàng
    let selectedProduct = products.find(product => product.productID === productID);
    // Lấy ngày hiện tại
    let currentDate = new Date().toISOString();
    // Gọi API backend để thêm đơn hàng
    fetch('http://localhost:8080/lab2/api/orders/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            order: {
                order_id: orderID,
                orderDate: currentDate, // Thêm ngày đặt hàng vào đây
                employee: {
                    emp_id: empID
                },
                customer: {
                    id: customerID,
                }
            },
            orderDetail: {
                order: {
                    order_id: orderID,
                },
                product: {
                    product_id: productID
                },
                note: note,
                quantity: quantity
            }
        })
    }).then(data => {
        // Thêm sản phẩm vào giỏ hàng
        cart.push({
            productID: productID,
            name: selectedProduct.name,
            quantity: quantity,
            orderID: orderID,
            customerID: customerID,
            empID: empID,
            note: note,
            // Thêm dữ liệu sản phẩm khác nếu cần
        });

        // Gọi hàm cập nhật giao diện giỏ hàng
        updateCartDisplay();
    })
        .catch(error => {
            console.error('Lỗi khi thêm đơn hàng:', error);
        });

}


// Hàm cập nhật giao diện giỏ hàng
function updateCartDisplay() {
    // Làm gì đó để cập nhật hiển thị giỏ hàng
    // Ví dụ: cập nhật số lượng sản phẩm trong giỏ hàng và hiển thị danh sách sản phẩm trong giỏ hàng
    let cartItems = document.getElementById('cart-items');
    cartItems.innerHTML = '';

    for (let item of cart) {
        let cartItem = document.createElement('li');
        cartItem.textContent = `${item.name}, Số lượng: ${item.quantity}`;
        cartItems.appendChild(cartItem);
    }
}


function checkout() {
    //Lấy id của order
    let orderId = document.getElementById('order-id-input').value;
    // Gọi API backend để lấy danh sách orderdetail của đơn hàng
    fetch(`http://localhost:8080/lab2/api/orders/${orderId}/detail`) //Có giá trị truyền vào thì 0 được dùng nháy đơn '' mà phải dùng ``
        .then(response => response.json())
        .then(orderDetails => {
            // Lấy tổng tiền của đơn hàng
            fetch(`http://localhost:8080/lab2/api/orders/${orderId}/totalPrice`)
                .then(response => response.text())
                .then(totalPrice => {
                    // Mã hóa dữ liệu JSON
                    let encodedOrderDetails = encodeURIComponent(JSON.stringify(orderDetails));
                    // Chuyển đến trang thanhtoan.html và truyền thông tin đơn hàng và tổng tiền
                    window.location.href = `thanhtoan.html?orderDetails=${encodedOrderDetails}&totalPrice=${totalPrice}`;
                })
                .catch(error => console.error('Lỗi khi lấy tổng tiền đơn hàng:', error));
        })
        .catch(error => console.error('Lỗi khi lấy danh sách orderdetail:', error));
}





