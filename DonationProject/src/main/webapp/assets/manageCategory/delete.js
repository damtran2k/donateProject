function confirmDelete(id) {
  if (confirm('Are you sure to delete?')) {
    window.location.href = '/DonationProject/deleteC?idC='+id;
  } else {
    return false;
  }
}