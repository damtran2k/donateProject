
function confirmCancel() {

	if (confirm("Are you sure you want to cancel?")) {
		redirectToManageFoundation();
	}
}

function redirectToManageFoundation() {
	window.location.href = "/listFoundationController";
}


