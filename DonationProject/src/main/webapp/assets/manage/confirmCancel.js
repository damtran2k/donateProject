
   function confirmCancel() {
    if (confirm("Are you sure you want to cancel?")) {
        redirectToManageCategory();
    }
}

function redirectToManageCategory() {
    window.location.href = "manageCategory";
}


