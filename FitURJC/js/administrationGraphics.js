<<<<<<< HEAD
$(document).ready(function(){
    "use strict";
=======
/*$(document).ready(function(){
    //var popCanvas = $("#popChart");
    //var popCanvas = document.getElementById("popChart");
    var popCanvas = document.getElementById("popChart").getContext("2d");
>>>>>>> 4175427db5ed6bede717159fe3d5713c7750674f

    var datos= {
        type: "pie",
        data: {
            datasets: [{
                data: [
                    40,
                    22,
                    38,
                    17,
                    62,
                    10,
                ],
            backgroundColor: [
                    "#F7464A",
                    "#46BFBD",
                    "#FDB45C",
                    "#949FB1",
                    "#4D5360",
                    "#FDB450",
                ],
            }],
            labels: [
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
            ]
        },
        options: {
            responsive: true,
        }
    };

    //var popCanvas = $("#popChart");
    //var popCanvas = document.getElementById("popChart");
    var popCanvas = document.getElementById('popChart').getContext('2d');
    window.pie = new Chart(popCanvas,datos);
});
*/