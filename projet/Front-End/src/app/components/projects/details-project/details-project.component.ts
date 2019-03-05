import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-project',
  templateUrl: './details-project.component.html',
  styleUrls: ['./details-project.component.css']
})
export class DetailsProjectComponent implements OnInit {

  title;
  client = {phone: 1123, email: '@gmail', entreprise: 'entreprise', doc: ['doc1', 'doc2']};
  image;
  description;
  demo;

  constructor() { }

  ngOnInit() {
    this.title = 'proj';
    this.description = 'description';
    this.demo = ['11.jpg', '12.jpg', '13.jpg'];
  }

}
