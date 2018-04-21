import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-graphics',
  templateUrl: './admin-graphics.component.html',
  styleUrls: ['./admin-graphics.component.css']
})

export class AdminGraphicsComponent {

  doughnutChartLabels:string[] = ['Strength', 'Cardio', 'Freestyle', 'Dance','Mind'];
  doughnutChartData:number[] = [1, 6, 2, 2, 1];
  doughnutChartType:string = 'doughnut';

  chartClicked(e:any):void {
    console.log(e);
  }

  chartHovered(e:any):void {
    console.log(e);
  }

}

