$(document).ready(function() {
	$('#button').click(function() {
		$.ajax({
			url : 'game',
			type : 'POST',
			success : function(responseText) {
                var parsed = JSON.parse(responseText);

                for (index = 0; index <= 9; index++) {
                    var row = document.createElement('div');
                    row.id = 'row'+index;
                    row.className = 'row';
                    document.getElementById('board').appendChild(row);

                }

                for(rowNumber=0;rowNumber<=9;rowNumber++){
                    for(boxNumber=0;boxNumber<=9;boxNumber++){
                        var box = document.createElement('div');
                        box.id = 'box'+boxNumber;
                        box.className = parsed[rowNumber][boxNumber];
                        document.getElementById('row'+rowNumber).appendChild(box)
                    }

                }

                //$('#board').text(parsed);
			}
		});
	});


});