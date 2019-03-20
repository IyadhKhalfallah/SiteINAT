import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { PhotosService } from 'src/app/services/photos.service';
import { FormationsService } from 'src/app/services/formations.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  projects = [];

  events = [
    // tslint:disable-next-line:max-line-length
    {
      id: 1,
      img: 'affiche/forum-6Affiche.jpg',
      date: '14-11-2018',
      name: '6 ème édition du forum de l\'emploi et des stages',
      description:
        // tslint:disable-next-line:max-line-length
        'L’agriculture tunisienne revêt une importance cruciale de par sa contribution à la sécurité alimentaire et à la garantie d’une activité et d’une source de revenu à la population rurale. Dans ce contexte, plusieurs filières phares ont connu un essor appréciable et ont enregistré des performances inédites notamment l’huile d’olive et les dattes.'
    }
  ];

  counters = [
    { nb: 120, title: 'title1' },
    { nb: 132, title: 'title2' },
    { nb: 152, title: 'title3' },
    { nb: 121, title: 'title4' }
  ];

  formations = [];

  values = [
    {
      title: 'La prospection',
      description:
        'La prospection, la réalisation et la commercialisation des projets.'
    },
    {
      title: 'Les formations',
      description: 'Les formations approfondies en Soft et Hard-skills.'
    },
    // tslint:disable-next-line:max-line-length
    {
      title: 'Les événements',
      description:
        'Les événements stratégiques pour la promotion et de l\'image de marque et des projets entrepris .'
    }
  ];

  sponsors = ['1.png', '2.png', '3.png', '4.png', '5.png', '6.png'];

  constructor(
    private projectService: ProjectsService,
    private photoService: PhotosService,
    private formationService: FormationsService
  ) {}

  ngOnInit() {
    this.projectService.getProjets().subscribe(data => {
      if (data) {
        for (let i = 0; i < 3; i++) {
          this.photoService
            .getProjetsPhotos(data[i].projectid)
            .subscribe(photos => {
              const project = {
                id: data[i].projectid,
                name: data[i].name,
                img: photos[0].path
              };
              this.projects.push(project);
            });
          console.log(this.projects);
        }
      }
    });
    // Formation
    this.formationService.getFormations().subscribe(data => {
      if (data) {
        for (let i = 0; i < 4; i++) {
          this.photoService
            .getFormationsPhotos(data[i].eventid)
            .subscribe(photos => {
              const a = photos.find(
                el =>
                  el.path.substr(1, el.path.indexOf('.') - 1) === data[i].name
              );
              if (a) {
                const formation = {
                  id: data[i].eventid,
                  name: data[i].name,
                  img: a.path
                };
                this.formations.push(formation);
              }
            });
        }
      }
    });
  }
}
