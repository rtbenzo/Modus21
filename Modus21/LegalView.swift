import SwiftUI

struct PrivacyNoticeView: View {
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 16) {
                Text("Effective Date: 4 August 2026")
                    .font(.subheadline.weight(.semibold))
                    .foregroundStyle(Brand.navy)
                Text("This notice describes the privacy practices Modus21, LLC publishes for www.modus21.com and for personal information collected in the course of its business.")
                    .font(.body)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)

                legalBlock(
                    "What may be collected",
                    "Personal information can include a name, physical address, telephone number, email address, emergency contact details, company affiliation, and associated interests. Other information can include browser and device details, usage data, demographic or location information, and statistical or aggregated data. When other information is combined with personal information, Modus21 treats the combination as personal information."
                )
                legalBlock(
                    "How it is used",
                    "Published uses include responding to requests, employment consideration and human resources, submitting bids and proposals, security and fraud prevention, legal compliance, and testing, research, and improvement of the site and services."
                )
                legalBlock(
                    "Cookies and analytics",
                    "The site may use cookies, web server logs, and third-party analytics to understand traffic and to prefill forms. Browser settings can refuse cookies. Server logs may include device, browser, language, time zone, referring page, and IP address."
                )
                legalBlock(
                    "Sharing",
                    "Modus21 states that it does not share gathered or aggregated demographic information except when required by law or legal process, when formally requested by law enforcement or government entities, when disclosure is necessary to prevent harm or financial loss, in connection with investigations of security events or illegal activity, or for any other legal purpose."
                )
                legalBlock(
                    "Automated access",
                    "Site content is provided for human visitors and authorized business use. Bots, scrapers, and similar automated access are prohibited without prior written permission, including use of site content to train or improve AI or machine learning models. Recognized search engines may index public pages. Questions can be sent to careers@modus21.com or 843-958-8900."
                )
                legalBlock(
                    "Security and changes",
                    "Modus21 maintains safeguards and states that no internet system can be fully secure. The notice can change by posting an update on the site. The effective date at the top of the notice shows the latest revision."
                )

                Link(destination: Company.privacyURL) {
                    FilledAction(title: "Read the Full Notice")
                }
                .padding(.top, 4)
            }
            .padding(20)
        }
        .screenBackground()
        .navigationTitle("Privacy Notice")
        .navigationBarTitleDisplayMode(.inline)
    }
}

struct AccessibilityStatementView: View {
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 16) {
                Text("Effective Date: 4 August 2026")
                    .font(.subheadline.weight(.semibold))
                    .foregroundStyle(Brand.navy)
                Text("Modus21, LLC is committed to making www.modus21.com accessible to the widest possible audience, including people with disabilities. The public site aims to conform to Section 508 and WCAG 2.0 Level AA.")
                    .font(.body)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)

                legalBlock(
                    "Published practices",
                    "Semantic headings and landmarks, keyboard access, visible focus, text alternatives for meaningful images, a skip link, support for reduced motion where animations are used, and a clear indication when a link opens in a new tab."
                )
                legalBlock(
                    "Known limitations",
                    "Modus21 notes that some secondary text contrast, reduced-motion behavior, and third-party content may not yet meet every standard. Third-party sites such as LinkedIn and external job systems follow those providers' practices."
                )
                legalBlock(
                    "Feedback",
                    "If you have trouble with the website or need an accommodation, call 843-958-8900 or email careers@modus21.com. Describe the page, the barrier, and any assistive technology you use."
                )

                Link(destination: Company.accessibilityURL) {
                    FilledAction(title: "Read the Full Statement")
                }
                .padding(.top, 4)
            }
            .padding(20)
        }
        .screenBackground()
        .navigationTitle("Accessibility")
        .navigationBarTitleDisplayMode(.inline)
    }
}

private struct LegalBlock: View {
    let title: String
    let bodyText: String

    var body: some View {
        VStack(alignment: .leading, spacing: 6) {
            Text(title)
                .font(.headline)
                .foregroundStyle(Brand.ink)
            Text(bodyText)
                .font(.body)
                .foregroundStyle(Brand.muted)
                .fixedSize(horizontal: false, vertical: true)
        }
    }
}

private func legalBlock(_ title: String, _ body: String) -> some View {
    LegalBlock(title: title, bodyText: body)
}
