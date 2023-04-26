// Lấy thẻ <a> có id là "addEmployeeLink"
const addEmployeeLink = document.querySelector('#addEmployeeLink');

// Thêm sự kiện click vào thẻ <a>
addEmployeeLink.addEventListener('click', function() {
  // Lấy thẻ modal
  const addEmployeeModal = document.querySelector('#addEmployeeModal');
  // Hiển thị modal
  addEmployeeModal.style.display = 'block';
});