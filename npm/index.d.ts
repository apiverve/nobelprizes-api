declare module '@apiverve/nobelprizes' {
  export interface nobelprizesOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface nobelprizesResponse {
    status: string;
    error: string | null;
    data: NobelPrizesData;
    code?: number;
  }


  interface NobelPrizesData {
      count:       number;
      filteredOn:  string[];
      nobelPrizes: NobelPrize[];
  }
  
  interface NobelPrize {
      firstName:           string;
      lastName:            string;
      born:                Date;
      died:                Date;
      countryborn:         string;
      countrybornCode:     string;
      bornCity:            string;
      diedCountry:         string;
      diedCountryCode:     string;
      diedCity:            string;
      gender:              string;
      year:                string;
      category:            string;
      motivation:          string;
      organization:        string;
      organizationCity:    string;
      organizationCountry: string;
  }

  export default class nobelprizesWrapper {
    constructor(options: nobelprizesOptions);

    execute(callback: (error: any, data: nobelprizesResponse | null) => void): Promise<nobelprizesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: nobelprizesResponse | null) => void): Promise<nobelprizesResponse>;
    execute(query?: Record<string, any>): Promise<nobelprizesResponse>;
  }
}
