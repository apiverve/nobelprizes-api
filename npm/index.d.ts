declare module '@apiverve/nobelprizes' {
  export interface nobelprizesOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface nobelprizesResponse {
    status: string;
    error: string | null;
    data: NobelPrizesData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface NobelPrizesData {
      count:       number | null;
      filteredOn:  (null | string)[];
      nobelPrizes: { [key: string]: null | string }[];
  }

  export default class nobelprizesWrapper {
    constructor(options: nobelprizesOptions);

    execute(callback: (error: any, data: nobelprizesResponse | null) => void): Promise<nobelprizesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: nobelprizesResponse | null) => void): Promise<nobelprizesResponse>;
    execute(query?: Record<string, any>): Promise<nobelprizesResponse>;
  }
}
