var popCanvas = document.getElementById("popChart");
var barChart = new Chart(popCanvas, {
  type: 'pie',
  data: {
    labels: ["Aerobic", "Body Combat", "Crossfit", "Step", "Spinning", "Zumba"],
    datasets: [{
      label: 'Population',
      data: [128, 56, 235, 140, 68, 94],
      backgroundColor: [
        'rgba(17, 36, 119, 0.6)',
        'rgba(39, 110, 192, 0.6)',
        'rgba(51, 68, 87, 0.6)',
        'rgba(27, 48, 167, 0.6)',
        'rgba(131, 140, 189, 0.6)',
        'rgba(88, 93, 119, 0.6)'
      ]
    }]
  }
});

