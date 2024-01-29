package ru.random_user

import ru.random_user.data.retrofit.dto.Result
import ru.random_user.data.room.entity.UserDB
import ru.random_user.domain.entity.User

fun UserDB.toUser() : User{
    return User(
        id = this.id.toString(),
        gender = this.gender,
        nat = this.nat,
        name = this.name,
        email = this.email,
        login = this.login,
        password = this.login,
        phone = this.phone,
        picture = this.picture,
        age = this.age,
        address = this.address,
        street = this.street,
        coordinates = this.coordinates
    )
}

fun Result.toUserDB() : UserDB {
    return UserDB(
        id = 0,
        gender = this.gender,
        nat = this.nat,
        name = this.name.title + " " + this.name.first + " " + this.name.last,
        email = this.email,
        login = this.login.username,
        password = this.login.password,
        phone = this.phone,
        picture = this.picture.large,
        age = this.dob.age.toString(),
        address = this.location.country + " "
                + this.location.state + " "
                + this.location.city,
        street = this.location.street.name + " " + this.location.street.number,
        coordinates = this.location.coordinates.latitude + ", " + this.location.coordinates.longitude
    )
}