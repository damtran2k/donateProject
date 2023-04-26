
   function confirmCancel() {
    if (confirm("Are you sure you want to cancel?")) {
        redirectToManageFund();
    }
}

function redirectToManageFund() {
    window.location.href = "listFundController";
}


