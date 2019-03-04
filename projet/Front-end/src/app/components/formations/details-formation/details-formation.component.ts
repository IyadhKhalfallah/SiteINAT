import { Component, OnInit } from '@angular/core';
import { FormationsService } from 'src/app/services/formations.service';

@Component({
  selector: 'app-details-formation',
  templateUrl: './details-formation.component.html',
  styleUrls: ['./details-formation.component.css']
})
export class DetailsFormationComponent implements OnInit {

  title;
  image;
  description;
  demo;

  constructor(private formationService: FormationsService) { }

  ngOnInit() {
    this.title = 'Stress Management';
    this.image  = 'stress-management.jpg';
    // tslint:disable-next-line:max-line-length
    this.description = 'Appliquer sa stratégie de gestion du stress dans la durée. Mieux gérer ses émotions en situations de stress. Faire appel à ses ressources individuelles. Récupérer rapidement.';
    this.demo = ['stressManagement1.jpg', 'stressManagement2.jpg'];
  }

}
