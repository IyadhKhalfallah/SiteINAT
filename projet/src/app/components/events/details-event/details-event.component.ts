import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-event',
  templateUrl: './details-event.component.html',
  styleUrls: ['./details-event.component.css']
})
export class DetailsEventComponent implements OnInit {

  image: string;
  title: string;
  date: string;
  orgonaziedBy: string[];
  shortDescription: string;
  longDescription: string;
  gallery: string[];

  constructor() { }

  ngOnInit() {
    this.image = 'news-11.jpg';
    this.title = 'title1';
    this.date = new Date().toISOString().split('T')[0];
    this.orgonaziedBy = ['JE1', 'JE2'];
    this.shortDescription = 'Short description';
    this.longDescription =  'Long description';
    this.gallery = ['19.jpg', '20.jpg', '21.jpg'];
  }

}
