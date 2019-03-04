import { Component, OnInit } from '@angular/core';
import { FormationsService } from 'src/app/services/formations.service';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-formations',
  templateUrl: './formations.component.html',
  styleUrls: ['./formations.component.css']
})
export class FormationsComponent implements OnInit {
  formations = [
    { id: 1, title: 'Stress Management', image: 'stress-management.jpg' }
  ];
  constructor(
    private formationService: FormationsService,
    private photoService: PhotosService
  ) {}

  ngOnInit() {
    this.formationService.getFormations().subscribe(data => {
      if (data) {
        data.forEach(element => {
          this.photoService
            .getFormationsPhotos(element.eventid)
            .subscribe(photos => {
              const formation = {
                id: element.eventid,
                title: element.name,
                image: photos[1].path
              };
              this.formations.push(formation);
            });
        });
      }
    });
  }
}
