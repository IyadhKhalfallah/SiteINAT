import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formations',
  templateUrl: './formations.component.html',
  styleUrls: ['./formations.component.css']
})
export class FormationsComponent implements OnInit {
  formations = [
    {id: 1,  title: 'Stress Management', image: 'stress-management.jpg'}
  ];
  constructor() { }

  ngOnInit() {
  }

}
