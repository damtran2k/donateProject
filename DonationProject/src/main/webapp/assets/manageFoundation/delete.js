function confirmDeleteF(id) {
  if (confirm('Do you want to delete?')) {
    window.location.href = 'deleteF?id='+id;
  } else {
    return false;
  }
}