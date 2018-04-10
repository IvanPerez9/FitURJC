import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-graphics',
  templateUrl: './admin-graphics.component.html',
  styleUrls: ['./admin-graphics.component.css']
})
export class AdminGraphicsComponent {

  // Doughnut
  public doughnutChartLabels:string[] = ['Body pump', 'Body combat', 'Cycling'];
  public doughnutChartData:number[] = [350, 450, 100];
  public doughnutChartType:string = 'doughnut';

  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }
  public nums_rand(){
    this.doughnutChartData=[
      Math.round(Math.random()*100),
      Math.round(Math.random()*100),
      Math.round(Math.random()*100)
    ]
  }

}

