package furhatos.app.intentionaltalk

import furhatos.app.intentionaltalk.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class IntentionaltalkSkill : Skill() {
    override fun start() {
        Flow().run(Idle)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
