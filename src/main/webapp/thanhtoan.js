
// Lấy thông tin đơn hàng và tổng tiền từ tham số URL
let params = new URLSearchParams(window.location.search);
let orderDetails = JSON.parse(params.get('orderDetails'));
let totalPrice = parseFloat(params.get('totalPrice'));

// Hiển thị danh sách sản phẩm của đơn hàng
let orderDetailsDiv = document.getElementById('order-details');
orderDetailsDiv.innerHTML = '<h2>Danh sách sản phẩm:</h2>';

for (let orderDetail of orderDetails) {
    let productDiv = document.createElement('div');
    productDiv.innerHTML = `
                <p>Tên sản phẩm: ${orderDetail.product.name}</p>
                <p>Giá: $${orderDetail.price.toFixed(2)}</p>
                <p>Số lượng: ${orderDetail.quantity}</p>
                <hr>
            `;
    orderDetailsDiv.appendChild(productDiv);
}

// Hiển thị tổng tiền
let totalPriceSpan = document.getElementById('total-price');
totalPriceSpan.textContent = `$${totalPrice.toFixed(2)}`;