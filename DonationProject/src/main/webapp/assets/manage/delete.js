function confirmDelete(id) {
  if (confirm('Bạn có chắc chắn muốn xóa?')) {
    window.location.href = '/Donation/deleteC?idC='+id;
  } else {
    return false;
  }
}