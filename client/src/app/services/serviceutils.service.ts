import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bundle } from '../model/bundle';
import { Observable } from 'rxjs';

const httpUploadOption = {
  httpHeader: new HttpHeaders({
      "Content-Type":"application/json"
  }),
  observe: 'response' as 'body'
};

interface BudleResponses {
  bundleList: Bundle[];
}

interface BudleResponse {
  bundle: Bundle;
}

@Injectable({
  providedIn: 'root'
})
export class ServiceutilsService {
  constructor(private httpClient: HttpClient) { }

  upload(formData: any): Observable<BudleResponse>{
    return this.httpClient.post<BudleResponse>('http://localhost:8080/upload', formData, httpUploadOption);
  }

  getBundleList(bundleId: String): Observable<BudleResponses> {
    const reqParams = new HttpParams().set('bundleId', bundleId.toString());
    return this.httpClient.get<BudleResponses>("http://localhost:8080/bundle", {params: reqParams});
  }

  getAllBundleList(): Observable<BudleResponses> {
    return this.httpClient.get<BudleResponses>("http://localhost:8080/bundles");
  }
}
