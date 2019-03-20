import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { PhotosService } from 'src/app/services/photos.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-project',
  templateUrl: './details-project.component.html',
  styleUrls: ['./details-project.component.css']
})
export class DetailsProjectComponent implements OnInit {

  title;
  client = {};
  image;
  description;
  demo = [];

  constructor(private route: ActivatedRoute, private photoService: PhotosService, private projectService: ProjectsService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.projectService.getProjet(params['id']).subscribe(data => {
        if (data) {
            this.photoService
              .getProjetsPhotos(params['id'])
              .subscribe(photos => {
                photos.forEach(element => {
                  this.demo.push(element.path);
                });
                  this.client = {
                    phone: data.client.phone, email: data.client.email, entreprise: data.client.name
                  };
                  this.title = data.name;
                  this.description = data.description;

              });
        }
      });
   });
  }

}
