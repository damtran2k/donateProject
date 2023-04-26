function deleteSelectedItems() {
	const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
	var num = checkboxes.length;
	if( num >0 ){
	if (confirm('Are you sure you want to delete ' + num + ' items selected?')){ 
	// Get all checkboxes that are checked
  	// Get the values of all checked checkboxes
	  const ids = [];
	  checkboxes.forEach(function(checkbox) {
	    ids.push(checkbox.value);
	  });
	  // Set the value of the hidden input field to a comma-separated list of IDs
	  const itemIdsField = document.getElementById('itemIds');
	  itemIdsField.value = ids.join(',');	
	  // Submit the form to the server
	  const deleteItemsForm = document.getElementById('deleteItemsForm');
	  deleteItemsForm.submit();
  }
		
	}
	else {
		alert("You haven't selected yet!!!");
	}
 	
}










