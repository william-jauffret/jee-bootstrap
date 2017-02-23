$(document).ready(function() {
    var alreadyInit = false;
    var selectedPionId = "";
    var selectedPionColor="";
    $('#button1').click(function() {
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
                            box.id = 'box'+rowNumber+boxNumber;
                            box.className = parsed[rowNumber][boxNumber];
                            document.getElementById('row'+rowNumber).appendChild(box);
                            if(box.className ==="BLACK" && rowNumber <=3){
                                var pion = document.createElement('div');
                                pion.id = 'pion'+rowNumber+boxNumber;
                                pion.className = "PionWhite";
                                box.appendChild(pion);
                            } else if(box.className === "BLACK" && rowNumber>=6){
                                var pion = document.createElement('div');
                                pion.id = 'pion'+rowNumber+boxNumber;
                                pion.className = "PionBlack";
                                box.appendChild(pion);
                            }

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

    $(document).on("click",".PionWhite",function(){
        $('.PionWhite').html("");
        $('#choiceToMake').html("");
        var pionId = $(this).attr("id");
        selectedPionId = pionId;
        selectedPionColor = "WHITE"
        var choiceLeft = document.createElement('button');
        choiceLeft.id = 'choiceLeft';
        choiceLeft.className = "choice-left";
        document.getElementById("choiceToMake").appendChild(choiceLeft);

        var choiceRight = document.createElement('button');
        choiceRight.id = "choiceRight";
        choiceRight.className = "choice-right";
        document.getElementById("choiceToMake").appendChild(choiceRight);
    });

    $(document).on("click",".PionBlack",function(){
        $('.PionBlack').html("");
        $('#choiceToMake').html("");
        var pionId = $(this).attr("id");
        selectedPionId = pionId;
        selectedPionColor = "BLACK"
        var choiceLeft = document.createElement('button');
        choiceLeft.id = 'choiceLeft';
        choiceLeft.className = "choice-left";
        document.getElementById("choiceToMake").appendChild(choiceLeft);

        var choiceRight = document.createElement('button');
        choiceRight.id = "choiceRight";
        choiceRight.className = "choice-right";
        document.getElementById("choiceToMake").appendChild(choiceRight);
    });

    $(document).on("hover","#choiceToMake",function(){
        $('#'+selectedPionId).toggleClass( "selected-pion" )
    });
    $(document).on("click","#choiceRight",function(){
        $.ajax({
            url : 'clicright',
            type : 'POST',
            data: {
                pion: selectedPionId,
                color : selectedPionColor
            },
            success : function(responseText) {
                var parsedPions = JSON.parse(responseText);
                console.log(responseText)
                for(rowNumber=0;rowNumber<=9;rowNumber++){
                    parsedPions[rowNumber].forEach(function (pionIn) {
                        var pion = document.createElement('div');
                        pion.id = 'pion'+pionIn.x+pionIn.y;
                        pion.className = "PionBlack";
                        $('#box'+pionIn.x+pionIn.y).html(pion);
                    })
                }


            },
            error: function (jqXHR, textStatus, err) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(err)
            }
        })
    });

    $(document).on("click",".choice-left",function(){
    });






});