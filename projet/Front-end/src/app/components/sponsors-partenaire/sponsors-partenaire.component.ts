import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sponsors-partenaire',
  templateUrl: './sponsors-partenaire.component.html',
  styleUrls: ['./sponsors-partenaire.component.css']
})
export class SponsorsPartenaireComponent implements OnInit {
  sponsors = [
      {id: 1, name: 'sponsor1' , image: '5.png'},
      {id: 2, name: 'sponsor2' , image: '6.png'},
      {id: 3, name: 'sponsor3' , image: '7.png'},
      {id: 4, name: 'sponsor4' , image: '5.png'},
      {id: 5, name: 'sponsor5' , image: '6.png'}
      ];
  partners = [
      {id: 1, name: 'partner1', image: '5.png'},
      {id: 1, name: 'partner2', image: '6.png'}
      ];

  constructor() { }

  ngOnInit() {
  }

}
