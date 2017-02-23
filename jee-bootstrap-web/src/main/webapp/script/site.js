$(document).ready(function() {
    var alreadyInit = false;
    $('#button').click(function() {
        $.ajax({
            url : 'game',
            type : 'POST',
            success : function(responseText) {
                var parsed = JSON.parse(responseText);
                if(alreadyInit === false){
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
                            console.log(box.className)
                            if(box.className ==="BLACK" && rowNumber <=3){
                                var pion = document.createElement('div')
                                pion.id = 'pion'+rowNumber+boxNumber;
                                pion.className = "PionWhite"
                                box.appendChild(pion)
                            } else if(box.className === "BLACK" && rowNumber>=6){
                                var pion = document.createElement('div')
                                pion.id = 'pion'+rowNumber+boxNumber;
                                pion.className = "PionBlack"
                                box.appendChild(pion)
                            }
                            /*if(box.className === 'BLACK'){

                            }*/
                        }

                    }


                    alreadyInit = true;
                }


            },
            error: function (jqXHR, textStatus, err) {
                alert("bug");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(err)
            }
        })
    });

    $(document).on("click","#pion98",function(){
        alert('Prout')
    });




});