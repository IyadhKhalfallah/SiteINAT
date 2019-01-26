import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects = [
    {id: 1,  title: 'project1', image: 'services-11.jpg'},
    {id: 2,  title: 'project2', image: 'services-12.jpg'},
    {id: 3,  title: 'project3', image: 'services-7.jpg'},
    {id: 4,  title: 'project4', image: 'services-8.jpg'}
  ];

  constructor() { }

  ngOnInit() {
  }

}
