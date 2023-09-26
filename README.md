# REST API Project README

## Giới thiệu

Dự án REST API này là một phần của ứng dụng quản lý thông tin khách hàng, nhân viên, đơn hàng, chi tiết đơn hàng, sản phẩm và giá sản phẩm. Dự án này cung cấp các API để quản lý các dữ liệu này. Dưới đây là một tóm tắt về các package và thành phần chính trong dự án:

### Packages

1. **Models**: Package này chứa các lớp mô hình (Model) của dự án như Customer, Employee, Order, OrderDetail, Product, ProductImage và ProductPrice.

2. **DB**: Package này chứa lớp Connection, được sử dụng để thiết lập kết nối đến cơ sở dữ liệu.

3. **Dao**: Các package con sau đây chứa các lớp DAO (Data Access Object) để thực hiện các thao tác truy cập cơ sở dữ liệu:
   - **EmployeeDao**: Chứa các hàm để thêm, cập nhật, xóa, lấy thông tin, lấy tất cả nhân viên, và kích hoạt nhân viên.
   - **OrderDao**: Chứa các hàm để thêm đơn hàng, lấy đơn hàng theo ngày, lấy đơn hàng theo tháng và nhân viên trong tháng.
   - **OrderDetailDao**: Chứa các hàm để tính tổng giá trị đơn hàng, và lấy chi tiết đơn hàng theo ID đơn hàng.
   - **ProductDao**: Chứa các hàm để thêm, cập nhật, xóa, lấy thông tin, lấy tất cả sản phẩm, kích hoạt sản phẩm, hàm lấy đường dẫn, hàm lấy giá gần nhất của sản phẩm.

4. **Convert**: Package này chứa các lớp liên quan đến chuyển đổi dữ liệu:
   - **MapperContextResolver**: Resolver cho ObjectMapper để chuyển đổi JSON.
   - **OrderByDateDTO**: DTO (Data Transfer Object) cho đơn hàng theo ngày.
   - **OrderByEmployeeMonthDTO**: DTO cho đơn hàng theo nhân viên trong tháng.
   - **OrderByMonthDTO**: DTO cho đơn hàng theo tháng.
   - **ProductPricePath**: Đường dẫn đến giá sản phẩm.

5. **Resource**: Package này chứa các lớp nguồn (Resource) để xử lý yêu cầu API:
   - **EmployeeResource**: Xử lý yêu cầu liên quan đến nhân viên.
   - **OrderDetailResource**: Xử lý yêu cầu liên quan đến chi tiết đơn hàng.
   - **OrderRequest**: Mô hình yêu cầu đặt hàng.
   - **OrderResource**: Xử lý yêu cầu liên quan đến đơn hàng.
   - **ProductResource**: Xử lý yêu cầu liên quan đến sản phẩm.

6. **Service**: Package này chứa các lớp dịch vụ (Service) để xử lý logic liên quan đến các thực thể:
   - **EmployeeService**: Xử lý logic liên quan đến nhân viên.
   - **OrderDetailService**: Xử lý logic liên quan đến chi tiết đơn hàng.
   - **OrderService**: Xử lý logic liên quan đến đơn hàng.
   - **ProductService**: Xử lý logic liên quan đến sản phẩm.

7. **Config**: Chứa lớp RootApplication, cấu hình chính của ứng dụng.

8. **Demo**: Package này chứa các tệp demo để kiểm tra các lớp DAO.

9. **WebApp**: Chứa các tệp tài nguyên liên quan đến giao diện người dùng:
   - **index.html**: Trang chủ của ứng dụng.
   - **product.js**: JavaScript cho quản lý sản phẩm.
   - **style.css**: CSS cho giao diện.
   - **thanhtoan.css**: CSS cho trang thanh toán.
   - **thanhtoan.js**: JavaScript cho trang thanh toán.
   - **thanhtoan.html**: Trang thanh toán.

## Hướng dẫn cài đặt và chạy

Dự án này là một ứng dụng REST API, vì vậy bạn cần sử dụng một máy chủ web hoặc nền tảng dự án REST API để chạy ứng dụng. Dưới đây là các bước cài đặt và chạy dự án:

1. **Cài đặt môi trường**: Đảm bảo rằng bạn đã cài đặt Java Development Kit (JDK).

2. **Cấu hình cơ sở dữ liệu**: Thiết lập cơ sở dữ liệu và cập nhật thông tin kết nối trong lớp Connection trong package DB.

3. **Import dự án**: Import dự án vào môi trường phát triển của bạn (Eclipse, IntelliJ, NetBeans, vv.).

4. **Cấu hình máy chủ web**: Sử dụng máy chủ web hoặc nền tảng dự án REST API để triển khai ứng dụng. Cấu hình máy chủ và trỏ đến ứng dụng.

5. **Chạy ứng dụng**: Khởi động máy chủ web hoặc nền tảng dự án REST API và truy cập API qua URL tương ứng (ví dụ: http://localhost:8080/api/lab2).

6. **Truy cập giao diện người dùng**: Có thể sử dụng giao diện người dùng, truy cập trang chủ và các trang khác thông qua trình duyệt web.

## Thư viện và công nghệ sử dụng

Dự án này sử dụng các công nghệ và thư viện sau:
- Java
- Spring Framework (Spring Boot)
- RESTful API
- Hibernate (JPA)
- MySQL (hoặc cơ sở dữ liệu tương tự)
- HTML, CSS, JavaScript

## Đóng góp

Nếu bạn muốn đóng góp vào dự án hoặc báo cáo lỗi, vui lòng tạo issue hoặc gửi pull request vào repository GitHub của dự án [https://github.com/ThuyTien2111/www_lab2.git].

## Tác giả

Dự án này được phát triển bởi [Thuy Tien] 

Cảm ơn bạn đã sử dụng dự án của chúng tôi!
