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
  ];

  events = [
    // tslint:disable-next-line:max-line-length
    {id: 1, img: 'affiche/forum-6Affiche.jpg', date: '14-11-2018', name: '6 ème édition du forum de l\'emploi et des stages', description: 'L’agriculture tunisienne revêt une importance cruciale de par sa contribution à la sécurité alimentaire et à la garantie d’une activité et d’une source de revenu à la population rurale. Dans ce contexte, plusieurs filières phares ont connu un essor appréciable et ont enregistré des performances inédites notamment l’huile d’olive et les dattes.'}
  ];

  counters = [
    {nb: 120, title: 'title1'},
    {nb: 132, title: 'title2'},
    {nb: 152, title: 'title3'},
    {nb: 121, title: 'title4'}
  ];

  formations = [
    {id: 1, img: 'stress-management.jpg', name: 'Stress Management'}
  ];

  values = [
    {title: 'La prospection', description: 'La prospection, la réalisation et la commercialisation des projets.' },
    {title: 'Les formations', description: 'Les formations approfondies en Soft et Hard-skills.' },
    // tslint:disable-next-line:max-line-length
    {title: 'Les événements', description: 'Les événements stratégiques pour la promotion et de l\'image de marque et des projets entrepris .' },
  ];

  sponsors = [ '1.png', '2.png', '3.png', '4.png', '5.png', '6.png'];

  constructor() { }

  ngOnInit() {
  }

}
