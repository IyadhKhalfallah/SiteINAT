import { Component, OnInit } from '@angular/core';
import { FormationsService } from 'src/app/services/formations.service';
import { ActivatedRoute } from '@angular/router';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-details-formation',
  templateUrl: './details-formation.component.html',
  styleUrls: ['./details-formation.component.css']
})
export class DetailsFormationComponent implements OnInit {

  title;
  image;
  description;
  gallery = [];
  programme;

  constructor(private formationService: FormationsService, private route: ActivatedRoute, private photoService: PhotosService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.formationService.getFormation(params['id']).subscribe(data => {
        if (data) {
          this.photoService
            .getFormationsPhotos(params['id'])
            .subscribe(photos => {
              if (this.gallery.length === 0) {
                photos.forEach(element => {
                  this.gallery.push(element.path);
                });
              }
              this.gallery.shift();
              const a = photos.find(
                el =>
                  el.path.substr(1, el.path.indexOf('.') - 1) === data.name
              );
              if (a) {
                this.title = data.name;
                this.image = a.path;
                this.description = data.description;
              }
            });
        }
      });
    });
  }

}
