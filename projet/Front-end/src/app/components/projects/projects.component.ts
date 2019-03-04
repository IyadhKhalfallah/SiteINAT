import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects = [];

  constructor(private projectService: ProjectsService, private photoService: PhotosService) { }

  ngOnInit() {
    this.projectService.getProjets().subscribe(data => {
      if (data) {
        data.forEach(element => {
          this.photoService
            .getProjetsPhotos(element.projectid)
            .subscribe(photos => {
              const project = {
                id: element.projectid,
                title: element.name,
                image: photos[0].path
              };
              this.projects.push(project);
            });
        });
      }
    });
  }

}
