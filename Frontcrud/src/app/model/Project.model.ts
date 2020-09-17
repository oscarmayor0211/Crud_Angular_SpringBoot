export interface Project {
  id_project: number;
  id_company: Company;
  id_service: Service;
  id_market: Market;
  description: string;
  name: string;
}

export interface Company {
  id_company: number;
  name: string;
}

export interface Service {
  id_service: number;
  name: string;
}

export interface Market {
  id_market: number;
  name: string;
}
