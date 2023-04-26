function fundConfirmDelete(id) {
  if (confirm('Do you want to delete11?')) {
    window.location.href = '/DonationProject/deleteFund?id='+id;
  } else {
    return false;
  }
}