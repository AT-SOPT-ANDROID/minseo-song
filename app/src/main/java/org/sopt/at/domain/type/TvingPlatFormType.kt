package org.sopt.at.domain.type

enum class TvingPlatFormType(
    val title: String,
    val imageUrl: String
){
    KBO(
        title = "KBO",
        imageUrl = "https://image.tving.com/ntgs/operation/specialHall/2025/03/23/1742719432_1.png/dims/resize/F_webp,400"
    ),
    APPLETV(
        title = "Apple TV+",
        imageUrl ="https://image.tving.com/ntgs/operation/specialHall/2025/04/23/1745391599_1.png/dims/resize/F_webp,400"
    ),
    KBL(
        title = "KBL",
        imageUrl = "https://image.tving.com/ntgs/operation/specialHall/2024/12/10/1733821492_1.png/dims/resize/F_webp,400"
    ),
    KIDS(
        title = "키즈",
        imageUrl = "https://image.tving.com/ntgs/operation/specialHall/2024/10/21/1729475548_1.png/dims/resize/F_webp,400"
    ),
    UFC(
        title = "UFC",
        imageUrl = "https://image.tving.com/ntgs/operation/specialHall/2023/10/19/1697689505_1.png/dims/resize/F_webp,400"
    )
}