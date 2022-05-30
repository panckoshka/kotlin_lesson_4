package wallPost

import wallPost.attachment.*
import wallPost.service.WallService

fun main() {
    val service = WallService

    service.add(OriginalPost(ownerId = 1, text = "text1"))
    service.add(OriginalPost(ownerId = 2, text = "text2"))
    service.add(OriginalPost(ownerId = 3, text = "text3"))
    service.add(OriginalPost(ownerId = 3, text = null))

    println(service.getPosts()[3].text?.uppercase()?.length)

    if (service.getPosts()[3].text != null) {
        println(service.getPosts()[3].text!!.uppercase().length)
    }

    try {
        println(service.getPosts()[3].text!!.length)
    } catch (e: NullPointerException) {
        println("catched")
    }


    fun printPost(originalPost: OriginalPost) {
        println(originalPost)
    }
    println(service.checkText(service.getPosts()[3]))
    println(service.checkText(service.getPosts()[2]))


    for (originalPost: OriginalPost in service.getPosts()) {
        printPost(originalPost)
    }

    val photo1: Attachment = PhotoAttachment(Photo(1, 1, 1, 1))
    println(photo1.type)
    if (photo1 is PhotoAttachment) {
        println(photo1)
    }

    val video1: Attachment = VideoAttachment(VideoAttachment.Video(1, "xxx"))
    println(video1.type)

    val app1: Attachment = AppAttachment(1, "xxx", "xxx")

    val post1 = service.getPosts()[0]

    post1.attachments.add(photo1)
    post1.attachments.add(video1)
    post1.attachments.add(app1)

    if (video1 is VideoAttachment){
        println(video1.video)
    }

}

