
   function confirmCancel() {
    if (confirm("Are you sure you want to cancel?")) {
        redirectToManageUser();
    }
}

function redirectToManageUser() {
    window.location.href = "listUserController";
}


