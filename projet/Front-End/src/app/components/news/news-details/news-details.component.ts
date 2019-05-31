import { Component, OnInit } from '@angular/core';
import { NewService } from 'src/app/services/new.service';
import { ActivatedRoute } from '@angular/router';
import { PhotosService } from 'src/app/services/photos.service';
import { Meta } from '@angular/platform-browser';

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {

  image: string;
  title ;
  date  ;
  shortDescription  ;
  longDescription ;
  gallery: string[];
  news = [];

  constructor(private newsService: NewService, private route: ActivatedRoute, private photoService: PhotosService, private meta: Meta) { }

  ngOnInit() {
    // All the news
    this.newsService.getNews().subscribe(data => {
      if (data) {
        for (let i = 0; i < 4; i++) {
          if (data[i]) {
            this.photoService
              .getNewsPhotos(data[i].articleid)
              .subscribe(photos => {
                const news = {
                  id: data[i].articleid,
                  title: data[i].name,
                  description: data[i].shortdescription,
                  date: data[i].date.substr(0, 10),
                  image: photos[0].path
                };
                this.news.push(news);
              });
          }
        }
      }
    });

    // get one news
    this.route.params.subscribe(params => {
      this.newsService.getOneNews(params['id']).subscribe(data => {
        if (data) {
          this.photoService
            .getNewsPhotos(params['id'])
            .subscribe(photos => {
              this.image = photos[0].path;
              this.title = data.name;
              this.longDescription = data.longdescription;
              this.shortDescription = data.shortdescription;
              this.date = data.date.substr(0, 10);
                //console.log(data.name+" data.name");
                if(data.name) {
                    this.meta.updateTag({name: 'fbTitle', content: data.name});
                     this.meta.updateTag({name: 'fbDescription', content: data.shortdescription});
                    this.meta.updateTag({name: 'fbImage', content: 'http://inatjunior.tn/assets/images/news/' + photos[0].path});
                    this.meta.updateTag({property: 'og:url', content: window.location.href});
                }
            });
        }
      });
    });

//console.log(this.title+" this.title after update");
    if(this.title) {
        this.meta.updateTag({name: 'fbTitle', content: this.title});
        //console.log(this.meta.getTag('name=fbTitle').content);
        this.meta.updateTag({name: 'fbDescription', content: this.shortDescription});
        this.meta.updateTag({name: 'fbImage', content: 'http://inatjunior.tn/assets/images/news/' + this.image});
        this.meta.updateTag({property:'og:url', content:window.location.href});
    }
  }

  share(){
      /*window.open('http://www.facebook.com/sharer.php?u='+window.location.href,
          'sharer',
          'toolbar=0,status=0,width=626,height=436,left=200');*/
      let leftPosition, topPosition;
      //Allow for borders.
      leftPosition = (window.screen.width / 2) - ((626 / 2) + 10);
      //Allow for title and status bars.
      topPosition = (window.screen.height / 2) - ((436 / 2) + 50);
      //Open the window.

      //alert(this.meta.getTag('name=fbTitle').content);
      //alert(this.meta.getTag('name=fbDescription').content);

      window.open("http://www.facebook.com/sharer.php?href="+window.location.href,
          "Partege sur Facebook",
          "status=no,height=436," +
          "width=626" +
          ",resizable=yes,left="
          + leftPosition + ",top=" + topPosition + ",screenX=" + leftPosition + ",screenY="
          + topPosition + ",toolbar=no,menubar=no,scrollbars=no,location=no,directories=no");

      return false;
  }

}
