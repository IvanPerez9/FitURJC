import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-graphics',
  templateUrl: './admin-graphics.component.html',
  styleUrls: ['./admin-graphics.component.css']
})
export class AdminGraphicsComponent {

  // Doughnut
  public doughnutChartLabels:string[] = ['Strength', 'Cardio', 'Freestyle', 'Dance','Mind'];
  public doughnutChartData:number[] = [1, 6, 2, 2, 1];
  public doughnutChartType:string = 'doughnut';

  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }

}

