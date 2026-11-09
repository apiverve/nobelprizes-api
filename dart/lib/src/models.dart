/// Response models for the Nobel Prizes API.

/// API Response wrapper.
class NobelprizesResponse {
  final String status;
  final dynamic error;
  final NobelprizesData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  NobelprizesResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory NobelprizesResponse.fromJson(Map<String, dynamic> json) => NobelprizesResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? NobelprizesData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Nobel Prizes API.

class NobelprizesData {
  num? count;
  List<String>? filteredOn;
  List<NobelprizesDataNobelprizesItem>? nobelPrizes;

  NobelprizesData({
    this.count,
    this.filteredOn,
    this.nobelPrizes,
  });

  factory NobelprizesData.fromJson(Map<String, dynamic> json) => NobelprizesData(
      count: json['count'],
      filteredOn: (json['filteredOn'] as List?)?.cast<String>(),
      nobelPrizes: (json['nobelPrizes'] as List?)?.map((e) => NobelprizesDataNobelprizesItem.fromJson(e)).toList(),
    );
}

class NobelprizesDataNobelprizesItem {
  String? firstName;
  String? lastName;
  String? born;
  String? died;
  String? countryborn;
  String? countrybornCode;
  String? born city;
  String? diedCountry;
  String? diedCountryCode;
  String? diedCity;
  String? gender;
  String? year;
  String? category;
  String? motivation;
  String? organization;
  String? organizationCity;
  String? organizationCountry;

  NobelprizesDataNobelprizesItem({
    this.firstName,
    this.lastName,
    this.born,
    this.died,
    this.countryborn,
    this.countrybornCode,
    this.born city,
    this.diedCountry,
    this.diedCountryCode,
    this.diedCity,
    this.gender,
    this.year,
    this.category,
    this.motivation,
    this.organization,
    this.organizationCity,
    this.organizationCountry,
  });

  factory NobelprizesDataNobelprizesItem.fromJson(Map<String, dynamic> json) => NobelprizesDataNobelprizesItem(
      firstName: json['firstName'],
      lastName: json['lastName'],
      born: json['born'],
      died: json['died'],
      countryborn: json['countryborn'],
      countrybornCode: json['countrybornCode'],
      born city: json['born city'],
      diedCountry: json['diedCountry'],
      diedCountryCode: json['diedCountryCode'],
      diedCity: json['diedCity'],
      gender: json['gender'],
      year: json['year'],
      category: json['category'],
      motivation: json['motivation'],
      organization: json['organization'],
      organizationCity: json['organizationCity'],
      organizationCountry: json['organizationCountry'],
    );
}

class NobelprizesRequest {
  String? firstname;
  String? lastname;
  String? category;
  int? year;

  NobelprizesRequest({
    this.firstname,
    this.lastname,
    this.category,
    this.year,
  });

  Map<String, dynamic> toJson() => {
      if (firstname != null) 'firstname': firstname,
      if (lastname != null) 'lastname': lastname,
      if (category != null) 'category': category,
      if (year != null) 'year': year,
    };
}
