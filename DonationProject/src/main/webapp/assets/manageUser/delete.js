function confirmDeleteUser(id) {
  if (confirm('Do you want delete this User?')) {
    window.location.href = '/DonationProject/deleteUser?id='+id;
  } else {
    return false;
  }
}