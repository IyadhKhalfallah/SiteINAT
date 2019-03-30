import { Component, OnInit } from '@angular/core';
import { NewService } from 'src/app/services/new.service';
import { ActivatedRoute } from '@angular/router';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {

  image: string;
  title = 'title';
  date = '2018-05-05';
  shortDescription = 'short desc';
  longDescription = 'long desc';
  gallery: string[];
  news = [];

  constructor(private newsService: NewService, private route: ActivatedRoute, private photoService: PhotosService) { }

  ngOnInit() {
    // All the news
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

    // get one news
     this.route.params.subscribe(params => {
       this.newsService.getOneNews(params['id']).subscribe(data => {
         console.log(data);
         if (data) {
             this.photoService
               .getNewsPhotos(params['id'])
               .subscribe(photos => {
                   this.image = photos[0].path;
                   this.title = data.name;
                   this.longDescription = data.description;
                   this.date = data.date;
               });
         }
       });
    });

  }

}
