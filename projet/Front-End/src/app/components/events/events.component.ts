import { Component, OnInit } from '@angular/core';
import { EventsService } from 'src/app/services/events.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  p = 1;
  events = [
    // tslint:disable-next-line:max-line-length
    {id: 1, date: '14-11-2018', title: '6 ème édition du forum de l\'emploi et des stages', description: 'L’agriculture tunisienne revêt une importance cruciale de par sa contribution à la sécurité alimentaire et à la garantie d’une activité et d’une source de revenu à la population rurale, Dans ce contexte, plusieurs filières phares ont connu un essor appréciable et ont enregistré des performances inédites notamment l’huile d’olive et les dattes', image: 'affiche/forum-6Affiche.jpg', orgonaziedBy: ['Institut National Agronomique de Tunis ', 'JE INSAT']},
  ];

  constructor(private eventService: EventsService) { }

  ngOnInit() {
    this.eventService.getEvents().subscribe(data => console.log(data));
  }

}
