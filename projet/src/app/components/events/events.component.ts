import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  p = 1;
  events = [
    // tslint:disable-next-line:max-line-length
    {id: 1, date: new Date().toISOString().split('T')[0], title: 'event1', description: 'desc1', image: 'news-3.jpg', orgonaziedBy: ['JE Insat', 'JE Inat']},
    // tslint:disable-next-line:max-line-length
    {id: 2, date: new Date().toISOString().split('T')[0], title: 'event2', description: 'desc2', image: 'news-4.jpg', orgonaziedBy: ['JE Insat', 'JE Inat']},
    // tslint:disable-next-line:max-line-length
    {id: 3, date: new Date().toISOString().split('T')[0], title: 'event3', description: 'desc3', image: 'news-5.jpg', orgonaziedBy: ['JE Insat', 'JE Inat']},
    // tslint:disable-next-line:max-line-length
    {id: 4, date: new Date().toISOString().split('T')[0], title: 'event4', description: 'desc4', image: 'news-6.jpg', orgonaziedBy: ['JE Insat', 'JE Inat']}
  ];

  constructor() { }

  ngOnInit() {
  }

}
