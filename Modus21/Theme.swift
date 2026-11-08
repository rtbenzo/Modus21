import SwiftUI

enum Brand {
    /// Navy from the modus21.com wordmark and site chrome.
    static let navy = Color(red: 0 / 255, green: 61 / 255, blue: 105 / 255)
    /// Orange rule from the wordmark.
    static let orange = Color(red: 247 / 255, green: 148 / 255, blue: 65 / 255)
    /// Charcoal block behind "21" on the wordmark.
    static let charcoal = Color(red: 31 / 255, green: 31 / 255, blue: 31 / 255)
    static let ink = Color(red: 31 / 255, green: 31 / 255, blue: 31 / 255)
    static let muted = Color(red: 95 / 255, green: 95 / 255, blue: 95 / 255)
    static let canvas = Color(red: 244 / 255, green: 246 / 255, blue: 248 / 255)
    static let line = Color(red: 31 / 255, green: 31 / 255, blue: 31 / 255).opacity(0.08)
}

struct ScreenBackground: ViewModifier {
    func body(content: Content) -> some View {
        content
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
            .background(Brand.canvas)
    }
}

extension View {
    func screenBackground() -> some View {
        modifier(ScreenBackground())
    }
}

struct BrandCard<Content: View>: View {
    @ViewBuilder var content: Content

    var body: some View {
        content
            .padding(18)
            .frame(maxWidth: .infinity, alignment: .leading)
            .background(Color.white, in: RoundedRectangle(cornerRadius: 16, style: .continuous))
            .overlay {
                RoundedRectangle(cornerRadius: 16, style: .continuous)
                    .stroke(Brand.line, lineWidth: 1)
            }
    }
}

struct Eyebrow: View {
    let text: String

    var body: some View {
        HStack(spacing: 8) {
            RoundedRectangle(cornerRadius: 1)
                .fill(Brand.orange)
                .frame(width: 18, height: 3)
            Text(text.uppercased())
                .font(.caption.weight(.semibold))
                .tracking(1.1)
                .foregroundStyle(Brand.navy)
        }
        .accessibilityElement(children: .combine)
    }
}

struct MarkIcon: View {
    let systemImage: String
    var size: CGFloat = 36

    var body: some View {
        Image(systemName: systemImage)
            .font(.body.weight(.semibold))
            .foregroundStyle(Brand.navy)
            .frame(width: size, height: size)
            .background(Brand.navy.opacity(0.08), in: RoundedRectangle(cornerRadius: 10, style: .continuous))
            .accessibilityHidden(true)
    }
}

struct FilledAction: View {
    let title: String

    var body: some View {
        Text(title)
            .font(.headline)
            .foregroundStyle(.white)
            .frame(maxWidth: .infinity)
            .padding(.vertical, 14)
            .background(Brand.navy, in: RoundedRectangle(cornerRadius: 12, style: .continuous))
    }
}

struct OutlineAction: View {
    let title: String

    var body: some View {
        Text(title)
            .font(.headline)
            .foregroundStyle(Brand.navy)
            .frame(maxWidth: .infinity)
            .padding(.vertical, 14)
            .background(Color.white, in: RoundedRectangle(cornerRadius: 12, style: .continuous))
            .overlay {
                RoundedRectangle(cornerRadius: 12, style: .continuous)
                    .stroke(Brand.navy, lineWidth: 1.5)
            }
    }
}

struct ActionRow: View {
    let title: String
    let subtitle: String
    let systemImage: String

    var body: some View {
        HStack(spacing: 14) {
            MarkIcon(systemImage: systemImage)
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.body.weight(.semibold))
                    .foregroundStyle(Brand.ink)
                Text(subtitle)
                    .font(.subheadline)
                    .foregroundStyle(Brand.muted)
                    .multilineTextAlignment(.leading)
            }
            Spacer(minLength: 8)
            Image(systemName: "arrow.up.right")
                .font(.footnote.weight(.semibold))
                .foregroundStyle(Brand.muted)
                .accessibilityHidden(true)
        }
        .contentShape(Rectangle())
    }
}
