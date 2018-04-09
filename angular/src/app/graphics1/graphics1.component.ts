import { Component} from '@angular/core';

@Component({
  selector: 'app-graphics1',
  templateUrl: './graphics1.component.html',
  styleUrls: ['./graphics1.component.css']
})
export class Graphics1Component {

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
