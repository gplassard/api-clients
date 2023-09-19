$version: "2"

namespace footballdata

resource AreaResource {
    operations: [ListAreas, GetArea]
}

@readonly
@tags(["area"])
@http(method: "GET", uri: "/v4/areas")
operation ListAreas {
    input:= {
    }
    output:= {
        count: Integer
        filters: AreaFilters
        areas: AreaList
    }
}

@readonly
@tags(["area"])
@http(method: "GET", uri: "/v4/areas/{id}")
operation GetArea {
    input:= {
        @required
        @httpLabel
        id: String
    }
    output: Area
}

structure AreaFilters {

}

list AreaList {
    member: AreaItem
}

structure AreaItem {
    id: Integer
    name: String
    countryCode: String
    flag: String
    parentAreaId: Integer
    parentArea: String
}

structure Area {
    id: Integer
    name: String
    code: String
    flag: String
    parentAreaId: Integer
    parentArea: String
    childAreas: AreaList
}
