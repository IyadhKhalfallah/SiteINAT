import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { PhotosService } from 'src/app/services/photos.service';
import { FormationsService } from 'src/app/services/formations.service';
import { NewService } from 'src/app/services/new.service';
declare var jQuery: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  projects = [];
  formations = [];
  news = [
    {
      id: 1,
      img: 'affiche/forum-6Affiche.jpg',
      date: '14-11-2018',
      name: 'News 1',
      description:
        // tslint:disable-next-line:max-line-length
        'Description News 1'
    }
  ];
  events = [
    // tslint:disable-next-line:max-line-length
    {
      id: 1,
      img: 'affiche/forum-6Affiche.jpg',
      date: '14-11-2018',
      name: '6 ème édition du forum de l\'emploi et des stages',
      description:
        // tslint:disable-next-line:max-line-length
        'L’agriculture tunisienne revêt une importance cruciale de par sa contribution à la sécurité alimentaire et à la garantie d’une activité et d’une source de revenu à la population rurale Dans ce contexte, plusieurs filières phares ont connu un essor appréciable et ont enregistré des performances inédites notamment l’huile d’olive et les dattes'
    }
  ];

  counters = [
    { nb: 120, title: 'title1' },
    { nb: 132, title: 'title2' },
    { nb: 152, title: 'title3' },
    { nb: 121, title: 'title4' }
  ];

  values = [
    {
      title: 'La prospection',
      description:
        'La prospection, la réalisation et la commercialisation des projets'
    },
    {
      title: 'Les formations',
      description: 'Les formations approfondies en Soft et Hard-skills'
    },
    // tslint:disable-next-line:max-line-length
    {
      title: 'Les événements',
      description:
        'Les événements stratégiques pour la promotion et de l\'image de marque et des projets entrepris'
    }
  ];

  sponsors = [
    { name: 'Président', image: '_Président_(fromage).png' },
    { name: 'Agil', image: 'Agil.png' },
    { name: 'Alfa', image: 'Alfa.png' },
    { name: 'APIA', image: 'APIA.png' },
    { name: 'B lounge', image: 'B lounge.jpg' },
    { name: 'Bayer', image: 'Bayer.png' },
    { name: 'Ben Yedder', image: 'Ben Yedder.png' },
    { name: 'BFI', image: 'BFI.png' },
    { name: 'BIAT', image: 'BIAT.png' },
    { name: 'BNA', image: 'BNA.png' },
    { name: 'Cogite', image: 'Cogite.png' },
    { name: 'Comete Engineering', image: 'Comete Engineering.png' },
    { name: 'ILMS', image: 'ILMS.png' },
    { name: 'IMS', image: 'IMS.png' },
    { name: 'SCET', image: 'logo-SCET.svg' },
    { name: 'Mabrouka', image: 'Mabrouka.png' },
    { name: 'OHN', image: 'ONH.png' },
    { name: 'Orange Tunisie', image: 'Orange-Tunisie_logo.png' },
    { name: 'OVITA', image: 'OVITA.png' },
    { name: 'RED bull', image: 'RED bull.png' },
    { name: 'Ruspina', image: 'Ruspina.png' },
    { name: 'Sadira', image: 'Sadira.png' },
    { name: 'SFBT', image: 'SFBT.png' },
    { name: 'SNA', image: 'SNA.png' },
    { name: 'STB', image: 'STB.png' },
    { name: 'Toast', image: 'Toast.jpg' },
    { name: 'Toyota', image: 'Toyota.png' },
    { name: 'Tunisie Telecom', image: 'tunisie-teleco.png' },
    { name: 'UTAP', image: 'UTAP.png' },
    { name: 'Vitalait', image: 'vitalait.png' }
  ];

  constructor(
    private projectService: ProjectsService,
    private photoService: PhotosService,
    private formationService: FormationsService,
    private newsService: NewService
  ) {}

  ngOnInit() {
    // Projects
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
        }
      }
    });
    // Formations
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
    // News
    // this.newsService.getNews().subscribe(data => {
    //   if (data) {
    //     for (let i = 0; i < 4; i++) {
    //       this.photoService
    //         .getNewsPhotos(data[i].newsid)
    //         .subscribe(photos => {
    //             const news = {
    //               id: data[i].newsid,
    //               name: data[i].name,
    //               description: data[i].description,
    //               date: data[i].date,
    //               img: data[i].path
    //             };
    //             this.news.push(news);
    //         });
    //     }
    //   }
    // });
  }
}
