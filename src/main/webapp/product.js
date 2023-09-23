// Định nghĩa biến để lưu trữ danh sách sản phẩm và giỏ hàng
let products = [];
let cart = [];

// Lấy danh sách sản phẩm từ API
fetch('http://localhost:8080/lab2/api/products/show')
    .then(response => response.json())
    .then(data => {
        products.push(...data);
        displayProducts();
    })
    .catch(error => console.error('Lỗi khi tải danh sách sản phẩm:', error));

// Hiển thị danh sách sản phẩm
function displayProducts() {
    let productList = document.getElementById('product-list');

    products.forEach(product => {
        let productDiv = document.createElement('div');
        productDiv.classList.add('product');
        productDiv.innerHTML = `
            <h3>${product.name}</h3>
            <p>Giá: $${product.price.toFixed(2)}</p>
            <img src="${product.path}" alt="${product.name}" height="150" width="200">
            <button onclick="addToCart(${product.productID})">Đặt hàng</button>
        `;
        productList.appendChild(productDiv);
    });
}

// Thêm sản phẩm vào giỏ hàng
function addToCart(productId) {
    const product = products.find(p => p.productID === productId);
    if (product) {
        cart.push(product);
        updateCartDisplay();
    }
}

// Cập nhật hiển thị giỏ hàng
function updateCartDisplay() {
    const cartItemsList = document.getElementById('cart-items');
    cartItemsList.innerHTML = '';

    cart.forEach(item => {
        const cartItem = document.createElement('li');
        cartItem.classList.add('cart-item');
        cartItem.innerHTML = `
            <span>${item.name}</span>
            <span>$${item.price.toFixed(2)}</span>
        `;
        cartItemsList.appendChild(cartItem);
    });
}

// Xử lý sự kiện khi ấn nút Thanh toán
document.getElementById('checkout-button').addEventListener('click', () => {
    // Chuyển sang trang thanh toán (bạn cần viết trang thanh toán riêng)
    window.location.href = 'thanh-toan.html';
});
