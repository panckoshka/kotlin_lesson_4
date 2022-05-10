package wallPost

import wallPost.service.WallService

fun main() {
    val service = WallService

    service.add(Post(ownerId = 1, text = "text1"))
    service.add(Post(ownerId = 2, text = "text2"))
    service.add(Post(ownerId = 3, text = "text3"))

    fun printPost(post: Post) {
        println(post)
    }

    for (post: Post in service.getPosts()) {
        printPost(post)
    }


}

