import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  projects = [
    {id: 1, img: '7.jpg', name: 'proj1'},
    {id: 1, img: '10.jpg', name: 'proj2'},
    {id: 2, img: '8.jpg', name: 'proj3'},
    {id: 3, img: '9.jpg', name: 'proj4'},
    {id: 4, img: '10.jpg', name: 'proj4'}
  ];

  events = [
    {id: 1, img: 'news-1.jpg', name: 'event1', description: 'desc1'},
    {id: 2, img: 'news-2.jpg', name: 'event2', description: 'desc2'},
    {id: 3, img: 'news-3.jpg', name: 'event3', description: 'desc3'}
  ];

  counters = [
    {nb: 120, title: 'title1'},
    {nb: 132, title: 'title2'},
    {nb: 152, title: 'title3'},
    {nb: 121, title: 'title4'}
  ];

  formations = [
    {id: 1, img: 'services-1.jpg', name: 'formation 1'},
    {id: 2, img: 'services-2.jpg', name: 'formation 2'},
    {id: 3, img: 'services-3.jpg', name: 'formation 3'},
    {id: 4, img: 'services-4.jpg', name: 'formation 4'}
  ];

  values = [
    {title: 'value 1', description: 'description 1' },
    {title: 'value 2', description: 'description 2' },
    {title: 'value 3', description: 'description 3' },
  ];

  sponsors = [ '1.png', '2.png', '3.png', '4.png', '5.png', '6.png'];

  constructor() { }

  ngOnInit() {
  }

}
